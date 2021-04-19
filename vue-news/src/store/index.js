import Vue from 'vue';
import Vuex from 'vuex';
import { fetchNewsList, fetchAskList, fetchJobsList } from '../api/index';

Vue.use(Vuex);

// Vuex: 상태 관리 도구
// 상태라는 것은 여러 컴포넌트 간에 공유되는 데이터 속성
export const store = new Vuex.Store({
    state: {
        news: [],
        ask: [],
        jobs: []
    },
    mutations: {
        SET_NEWS(state, news) {
            state.news = news;
        },
        SET_ASK(state, ask) {
            state.ask = ask;
        },
        SET_JOBS(state, jobs) {
            state.jobs = jobs;
        }
    },
    actions: {
        FETCH_NEWS(context) {
            fetchNewsList()
            .then(response => {
                console.log(response.data);
                context.commit('SET_NEWS', response.data);
            })
            .catch(error => {
                console.log(error);
            })
        },
        FETCH_ASK(context) {
            fetchAskList()
            .then(response => {
                context.commit('SET_ASK', response.data);
            })
            .catch(error => {
                console.log(error);
            })
        },
        FETCH_JOBS(context) {
            fetchJobsList()
            .then(response => {
                context.commit('SET_JOBS', response.data);
            })
            .catch(error => {
                console.log(error);
            })
        }
    }
});