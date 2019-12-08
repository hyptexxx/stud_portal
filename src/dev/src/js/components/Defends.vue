<template>
    <div>
        <section id="right-side-content">
            <div class="right-side-content-header">
                <p class="main-font">Защиты</p>
            </div>
            <div class="right-side-content-body">
                <article class="entity" v-for="item in defends">
                    <input type="text" disabled class="main-font entity-input" placeholder="Дата защиты"
                           :value="item.date_def"/>
                    <input type="text" disabled class="main-font entity-input" placeholder="Преподаватель"
                           :value="item.name_teacher"/>
                    <input type="text" disabled class="main-font entity-input" placeholder="Студент"
                           :value="item.user_name"/>
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
                defends: [{
                    date_def: null,
                    user_name: '',
                    name_teacher: ''
                }]
            }
        },
        name: "Defends",
        methods: {
            formatDate(date) {
                let dd = date.getDate();
                if (dd < 10) dd = '0' + dd;

                let mm = date.getMonth() + 1;
                if (mm < 10) mm = '0' + mm;

                let yy = date.getFullYear() % 100;
                if (yy < 10) yy = '0' + yy;

                return dd + '.' + mm + '.' + yy;
            },
        },
        mounted: function () {
            axios.post('/api/getDefends').then(response => {
                let date
                this.defends.length = 0
                for (let i = 0; i < response.data.length; i++) {
                    date = this.formatDate(new Date(response.data[i].date_def))
                    this.defends.push({
                        date_def: date,
                        user_name: response.data[i].user_name,
                        name_teacher: response.data[i].name_teacher
                    })
                }
            })
        },
    }
</script>