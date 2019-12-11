<template>
    <div>
        <section id="right-side-content-filters">
            <span class="main-font right-side-content-filters-span">Фильтры</span>
            <div class="right-side-content-filters-body">
                <div class="selection">
                    <label class="main-font" for="student">Студент</label>
                    <select id="student" class="main-font" @change="studentChange($event)">
                        <option class="main-font" value="-1">не выбрано</option>
                        <option class="main-font" v-for="item in student" :value="item.user_id">
                            {{item.fio}}
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
                <p class="main-font">Публикации</p>
            </div>
            <div class="right-side-content-body">
                <article class="entity" v-for="item in publications">
                    <input type="text" class="main-font entity-input fio" placeholder="Название публицации" :value="item.name"/>
                    <input type="text" class="main-font entity-input nr" placeholder="Текст публикации" :value="item.text"/>
                </article>
            </div>
        </section>
    </div>
</template>

<script>
    import axios from 'axios'

    export default {
        data: function () {
            return {
                student: [{
                    user_id:0,
                    fio:'',
                    id_napr:0,
                    id_category:0
                }],
                nr: [{
                    fio: '',
                    id_n: 0,
                    id_teacher: 0
                }],
                publications: [{
                    id_publication: 0,
                    name: '',
                    text: '',
                    user_id: 0,
                    teacher_id:0
                }]
                , studentFilter: {}
                , teacherFilter: {}
            }
        },
        mounted: function () {
            axios.post('/api/getAllStudents').then(response => {
                this.student = response.data
            })
            axios.post('/api/getNr').then(response => {
                this.nr = response.data
            })
            axios.post('/api/getAllPublications').then(response => {
                this.publications = response.data
            })
        },
        methods: {
            studentChange: function (e) {
                let params = new URLSearchParams();
                this.teacherFilter = document.getElementById('nr')
                params.append('id_teacher', this.teacherFilter.value)
                params.append('id_student', e.target.value)
                axios.post('/api/refreshFilterNr/Publications', params).then(response => {
                    this.nr = response.data
                })
                axios.post('/api/doFilter/Publications', params).then(response => {
                    this.publications = response.data
                })
            },
            nrChange: function (e) {
                let params = new URLSearchParams();
                this.studentFilter = document.getElementById('studentFilter')
                params.append('id_teacher', e.target.value)
                params.append('id_student', this.studentFilter.value)
                axios.post('/api/refreshFilterStudent/Publications', params).then(response => {
                    this.student = response.data
                })
                axios.post('/api/doFilter/Publications', params).then(response => {
                    this.publications = response.data
                })
            }
        },
        name: "Publications"
    }
</script>
