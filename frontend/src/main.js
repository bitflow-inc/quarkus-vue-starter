import Vue from 'vue'
import Index from './views/Index.vue'

import "@fortawesome/fontawesome-free/css/all.min.css";

Vue.config.productionTip = false

const routes = {
  '/dashboard': Index
}

new Vue({
  data: {
    currentRoute: window.location.pathname
  },
  computed: {
    ViewComponent () {
      return routes[this.currentRoute] || Index
    }
  },
  render (h) { return h(this.ViewComponent) },
}).$mount('#app')
