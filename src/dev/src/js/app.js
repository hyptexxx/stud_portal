// Vue main file

import {main} from './moduels'
import Vue from 'vue'

import filters from './components/Filters'
import articles from './components/Articles'

window.onload = () => {
    main()
}

// ----------------------use-section-------------------------------------------->

// ----------------------------------------------------------------------------->


// ----------------------component-section-------------------------------------->


Vue.component('filters', filters);
Vue.component('articles', articles);

// ----------------------------------------------------------------------------->


// ---------------------Main-instance-of-Vue------------------------------------>

const app = new Vue({
    el: '#app',
});

// -------------------------Instances-of-Vue------------------------------------>



// ----------------------------------------------------------------------------->





