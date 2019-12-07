<template>
    <div>
        <section id="right-side-content-filters">
            <span class="right-side-content-filters-span">Фильтры</span>
            <div class="right-side-content-filters-body">
<!--                <div class="selection">-->
<!--                    <label for="napr">направление</label>-->
<!--                    <select id="napr" class="entity-input" @change="naprChange($event)">-->
<!--                        <option value="-1">не выбрано</option>-->
<!--                        <option v-for="item in napr" :value="item.id_napr">-->
<!--                            {{item.name}}-->
<!--                        </option>-->
<!--                    </select>-->
<!--                </div>-->
                <div class="selection">
                    <label for="kaf">кафедра</label>
                    <select id="kaf" class="entity-input" @change="kafChange($event)">
                        <option value="-1">не выбрано</option>
                        <option v-for="item in kaf" :value="item.id_kafedr">
                            {{item.name}}
                        </option>
                    </select>
                </div>
                <div class="selection">
                    <label for="nr">научный руководитель</label>
                    <select id="nr" class="entity-input" @change="nrChange($event)">
                        <option value="-1">не выбрано</option>
                        <option v-for="item in nr" :value="item.id_teacher">
                            {{item.fio}}
                        </option>
                    </select>
                </div>
            </div>
        </section>
    </div>
</template>

<script>
    import axios from 'axios'

    export default {
        data() {
            return {
                // napr: [{
                //     id_kaf: 0,
                //     id_napr: 0,
                //     name: ''
                // }],
                kaf: [{
                    id_kafedr: 0,
                    name: ''
                }],
                nr: [{
                    fio: '',
                    id_n: 0,
                    id_teacher: 0
                }]
                , naprFilter: {}
              //  , kafFilter: {}
                , teacherFilter: {}
            }
        },
        mounted: function () {
            // axios.post('/api/napr').then(response => {
            //     this.napr = response.data
            // })
            axios.post('/api/kaf').then(response => {
                this.kaf = response.data
            })
            axios.post('/api/nr').then(response => {
                this.nr = response.data
            })
        },
        methods: {
            // naprChange: function (e) {
            //     let params = new URLSearchParams();
            //     this.kafFilter = document.getElementById('kaf')
            //     this.teacherFilter = document.getElementById('nr')
            //     params.append('id_teacher', this.teacherFilter.value)
            //     params.append('id_napr', e.target.value)
            //     params.append('id_kaf', this.kafFilter.value)
            //     axios.post('/api/refreshFilters', params).then(response => {
            //
            //     })
            //     axios.post('/api/doFilter', params).then(response => {
            //
            //     })
            // },
            kafChange: function (e) {
                let params = new URLSearchParams();
           //     this.naprFilter = document.getElementById('napr')
                this.teacherFilter = document.getElementById('nr')
                params.append('id_teacher', this.teacherFilter.value)
              //  params.append('id_napr', this.naprFilter.value)
                params.append('id_kaf', e.target.value)
                axios.post('/api/refreshFilters', params).then(response => {

                })
                axios.post('/api/doFilter', params).then(response => {

                })
            },
            nrChange: function (e) {
                let params = new URLSearchParams();
          //      this.naprFilter = document.getElementById('napr')
                this.kafFilter = document.getElementById('kaf')
                params.append('id_teacher', e.target.value)
             //   params.append('id_napr', this.naprFilter.value)
                params.append('id_kaf', this.kafFilter.value)
                axios.post('/api/refreshFilters', params).then(response => {

                })
                axios.post('/api/doFilter', params).then(response => {

                })
            }
        },
        name: "filters"
    }
</script>