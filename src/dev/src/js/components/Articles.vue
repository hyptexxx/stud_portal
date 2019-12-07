<template>
    <div>
        <section id="right-side-content">
            <div class="right-side-content-header">
                <p>Пользователи</p>
            </div>
            <div class="right-side-content-body">
                <article class="entity">
                    <input type="text" class="entity-input fio" placeholder="ФИО"/>
                    <input type="text" class="entity-input nr" placeholder="Руководитель"/>
                    <input type="text" class="entity-input napr" placeholder="Направление"/>
                    <input type="text" class="entity-input pub_name" placeholder="Название публикации"/>
                    <input type="text" class="entity-input descr_name" placeholder="описание публикации"/>
                    <input type="text" class="entity-input type" placeholder="категория"/>
                </article>
            </div>
        </section>
    </div>
</template>

<script>
    export default {
        name: "Articles"
    }
</script>