import { fetchNewsList, fetchAskList, fetchJobsList, fetchUserInfo, fetchCommentItem} from '../api/index';

export default {
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
    FETCH_JOBS( {commit }) {
        fetchJobsList()
        .then( ({ data }) => {
            commit('SET_JOBS', data);
        })
        .catch(error => {
            console.log(error);
        })
    },
    FETCH_ASK( {commit} ) {
        fetchAskList()
        .then( ({data}) => {
            commit('SET_ASK', data);
        })
        .catch(error => {
            console.log(error);
        })
    },
    FETCH_USER( { commit }) {
        fetchUserInfo()
        .then( ({data}) => {
            commit('SET_USER', data);
        })
        .catch(error => {
            console.log(error);
        })
    },
    FETCH_ITEM({commit}, id) {
        fetchCommentItem(id)
        .then( ({data}) => {
            commit('SET_ITEM', data);
        })
        .catch(error => {
            console.log(error);
        })
    }
}