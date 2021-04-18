import Vue from 'vue';
import VueRouter from 'vue-router';
import NewsView from '../views/NewsView'
import JobsView from '../views/JobsView'
import AskView from '../views/AskView'

Vue.use(VueRouter);

export const router = new VueRouter({
  router: [
    {
      path: '/',
      redirect: '/news'
    },
    {
        // path: url 주소
        path: '/news',
        // component: url 주소가 갔을 때
        component: NewsView
    },
    {
        path: '/ask',
        component: AskView
    },
    {
        path: '/jobs',
        component: JobsView
    }
  ]
});
