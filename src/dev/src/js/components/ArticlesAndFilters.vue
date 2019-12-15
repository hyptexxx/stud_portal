<template>
    <div>
        <section id="right-side-content-filters">
            <span class="main-font right-side-content-filters-span">Фильтры</span>
            <div class="right-side-content-filters-body">
                <div class="selection">
                    <label class="main-font" for="kaf">кафедра</label>
                    <select id="kaf" class="main-font" @change="kafChange($event)">
                        <option class="main-font" value="-1">не выбрано</option>
                        <option class="main-font" v-for="item in kaf" :value="item.id_kafedr">
                            {{item.name}}
                        </option>
                    </select>
                </div>
                <div class="selection">
                    <label class="main-font" for="nr">научный руководитель</label>
                    <select id="nr" class="main-font" @change="nrChange($event)">
                        <option class="main-font" value="-1">не выбрано</option>
                        <option class="main-font" v-for="item in nr" :value="item.id_teacher">
                            {{item.fio}}
                        </option>
                    </select>
                </div>
            </div>
        </section>
        <section id="right-side-content">
            <div class="right-side-content-header">
                <p class="main-font">Пользователи</p>
            </div>
            <div class="right-side-content-body">
                <article class="entity" v-for="item in Articles" :data-user-id="item.id_user">
                    <form name="articleForm" @submit.prevent="sendUser($event)" class="articleForm entity"
                          :data-user-id="item.id_user"
                          style="display: inherit; border: none;justify-content: center;">
                        <input :data-user-id="item.id_user" type="text" name="student"
                               class="main-font entity-input fio" placeholder="ФИО" :value="item.fio_user"/>
                        <select :data-user-id="item.id_user" name="teacher" class="main-font entity-input fio"
                                @click="getTeacherList($event)" :data-id-napr="item.id_napr">
                            <option :value="item.id_teacher">По умолчанию: {{item.fio_teacher}}</option>
                            <option v-for="iterator in TeacherList" :value="iterator.id_teacher">{{iterator.fio}}
                            </option>
                        </select>
                        <select :data-user-id="item.id_user" name="napr" class="main-font entity-input fio"
                                @click="getNaprList()">
                            <option :value="item.id_napr">По умолчанию: {{item.name_napr}}</option>
                            <option v-for="iterator in NaprList" :value="iterator.id_napr">{{iterator.name}}</option>
                        </select>
                        <select :data-user-id="item.id_user" name="category" class="main-font entity-input fio"
                                @click="getCategoryList()">
                            <option :value="item.id_category">По умолчанию: {{item.category}}</option>
                            <option v-for="iterator in CategoryList" :value="iterator.id_category">
                                {{iterator.category}}
                            </option>
                        </select>
                        <input type="submit" class="sendUser entity-input">
                    </form>
                </article>
            </div>
        </section>
    </div>
</template>

<script>
    import axios from 'axios'

    export default {
        data() {
            return {
                kaf: [{
                    id_kafedr: 0,
                    name: ''
                }],
                nr: [{
                    fio: '',
                    id_n: 0,
                    id_teacher: 0
                }],
                NaprList: [{
                    id_napr: 0,
                    name: '',
                    id_kaferdr: 0
                }],
                CategoryList: [{
                    id_category: 0,
                    category: ''
                }],
                TeacherList: [{
                    id_teacher: 0,
                    id_n: 0,
                    fio: '',
                }],
                Articles: [{
                    id_user: 0,
                    fio_user: '',
                    id_teacher: 0,
                    fio_teacher: '',
                    id_napr: 0,
                    name_napr: '',
                    id_category: 0,
                    category: ''
                }]
                , naprFilter: {}
                , teacherFilter: {}
            }
        },
        mounted: function () {
            axios.post('/api/kaf').then(response => {
                this.kaf = response.data
            })
            axios.post('/api/getNr').then(response => {
                this.nr = response.data
            })
            axios.post('/api/getAllArticles').then(response => {
                this.Articles = response.data
            })
        },
        methods: {
            kafChange: function (e) {
                let params = new URLSearchParams();
                this.teacherFilter = document.getElementById('nr')
                params.append('id_teacher', this.teacherFilter.value)
                params.append('id_kaf', e.target.value)
                axios.post('/api/refreshFilterNr', params).then(response => {
                    this.nr = response.data
                })
                axios.post('/api/doFilter', params).then(response => {
                    this.Articles = response.data
                })
            },
            nrChange: function (e) {
                let params = new URLSearchParams();
                this.kafFilter = document.getElementById('kaf')
                params.append('id_teacher', e.target.value)
                params.append('id_kaf', this.kafFilter.value)
                axios.post('/api/refreshFilterKaf', params).then(response => {
                    this.kaf = response.data
                })
                axios.post('/api/doFilter', params).then(response => {
                    this.Articles = response.data
                })
            },
            getTeacherList: function (e) {
                let params = new URLSearchParams();
                params.append("id_napr", e.target.getAttribute("data-id-napr"))
                axios.post('/api/getTeacherListByNaprId', params).then(response => {
                    this.TeacherList = response.data
                })
            },
            getNaprList: function () {
                axios.post('/api/getNaprList').then(response => {
                    this.NaprList = response.data
                })
            },
            getCategoryList: function () {
                axios.post('/api/getCategoryList').then(response => {
                    this.CategoryList = response.data
                })
            },
            sendUser: function (e) {
                let params = new URLSearchParams();
                const fio = document.querySelector('input[data-user-id="' + e.target.getAttribute("data-user-id") + '"').value;
                const teacher = document.querySelector('select[name="teacher"][data-user-id="' + e.target.getAttribute("data-user-id") + '"').value;
                const napr = document.querySelector('select[name="napr"][data-user-id="' + e.target.getAttribute("data-user-id") + '"').value;
                const category = document.querySelector('select[name="category"][data-user-id="' + e.target.getAttribute("data-user-id") + '"').value;
                params.append("fio", fio)
                params.append("teacher", teacher)
                params.append("napr", napr)
                params.append("category", category)
                params.append("user_id", e.target.getAttribute("data-user-id"))
                axios.post('/api/setArticle', params).then(response => {
                })
            }
        },
        name: "articlesandfilters",
    }
</script>