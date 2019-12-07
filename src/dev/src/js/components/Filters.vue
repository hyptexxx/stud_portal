<template>
    <div>
        <section id="right-side-content-filters">
            <span class="right-side-content-filters-span">Фильтры</span>
            <div class="right-side-content-filters-body">
                <div class="selection">
                    <label for="napr">направление</label>
                    <select id="napr" class="entity-input">
                        <option v-for="item in napr">
                            {{item.category}}
                        </option>
                    </select>
                </div>
                <div class="selection">
                    <label for="kaf">кафедра</label>
                    <select id="kaf" class="entity-input">
                        <option>Тест1</option>
                        <option>Тест2</option>
                    </select>
                </div>
                <div class="selection">
                    <label for="nr">научный руководитель</label>
                    <select id="nr" class="entity-input">
                        <option>Тест1</option>
                        <option>Тест2</option>
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
            return{
                napr:[{
                    category:''
                }]
            }
        },
        mounted:function(){
            axios.post('/api/category').then(response=>{
                this.napr = response.data
            })

        },
        name: "filters"
    }
</script>