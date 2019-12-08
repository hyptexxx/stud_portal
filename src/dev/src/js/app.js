// Vue main file

import {main} from './moduels'
import Vue from 'vue'


import articlesandfilters from './components/ArticlesAndFilters'
import Defends from './components/Defends'
import Publications from './components/Publications'

window.onload = () => {
    main()
}

// ----------------------use-section-------------------------------------------->

// ----------------------------------------------------------------------------->


// ----------------------component-section-------------------------------------->


Vue.component('articlesandfilters', articlesandfilters);
Vue.component('publications', Publications);
Vue.component('defends', Defends);

// ----------------------------------------------------------------------------->


// ---------------------Main-instance-of-Vue------------------------------------>

const app = new Vue({
    el: '#app',
});

// -------------------------Instances-of-Vue------------------------------------>



// ----------------------------------------------------------------------------->





