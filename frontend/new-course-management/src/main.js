import { createApp } from 'vue';
import App from './App.vue';
import router from './router';
//import store from './store'; // 如果你有 Vuex store

const app = createApp(App);

app.use(router);
//app.use(store); // 如果你有 Vuex store
app.mount('#app');
