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
                <article class="entity" v-for="item in Articles">
                    <input type="text" class="main-font entity-input fio" placeholder="ФИО" :value="item.fio_user"/>
                    <input type="text" class="main-font entity-input nr" placeholder="Руководитель" :value="item.fio_teacher"/>
                    <input type="text" class="main-font entity-input napr" placeholder="Направление" :value="item.name_napr"/>
                    <input type="text" class="main-font entity-input type" placeholder="категория" :value="item.category"/>
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
                Articles:[{
                    id_user:0,
                    fio_user:'',
                    id_teacher:0,
                    fio_teacher:'',
                    id_napr:0,
                    name_napr:'',
                    id_category:0,
                    category:''
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
                axios.post('/api/refreshFilterNr', params).then(response => { this.nr = response.data })
                axios.post('/api/doFilter', params).then(response => { this.Articles = response.data })
            },
            nrChange: function (e) {
                let params = new URLSearchParams();
                this.kafFilter = document.getElementById('kaf')
                params.append('id_teacher', e.target.value)
                params.append('id_kaf', this.kafFilter.value)
                axios.post('/api/refreshFilterKaf', params).then(response => { this.kaf = response.data })
                axios.post('/api/doFilter', params).then(response => { this.Articles = response.data })
            }
        },
        name: "articlesandfilters",
    }
</script>