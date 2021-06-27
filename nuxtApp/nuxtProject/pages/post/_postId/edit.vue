<template>
    <div class="post-edit-page">
        <h1>게시물 수정</h1>
        <post-edit-form v-if="post" :post="post" @submit="onSubmit" />
        <p v-else>게시물 불러오는 중...</p>
    </div>
</template>

<script>
import { mapState } from 'vuex'
import PostEditForm from '@/components/PostEditForm'
import api from '@/api'

export default {
    name: 'PostEditPage',
    components: { PostEditForm },
    middleware: 'isAuthorized',
    computed: {
        ...mapState([ 'post' ])
    },
    methods: {
        onSubmit (payload) {
            const { title, contents } = payload
            api.put(`/posts/${this.post.id}`, {title, contents})
                .then(res => {
                    alert('게시물이 성공적으로 수정되었습니다.')
                    this.$router.push({
                        path: '/post/' + res.data.id.toString()
                    })
                })
                .catch(err => {
                    if (err.response.status === 401) {
                        alert('로그인이 필요합니다.')
                        this.$router.push({ path: '/signin' })
                    } else if (err.response.status === 403) {
                        alert(err.response.data.msg)
                        this.$router.back()
                    } else {
                        alert(err.response.data.msg)
                    }
                })
        }
    },
    validate({ app, params, store }) {
        store.dispatch('fetchPost', params.postId)
        .then(res => {
          const post = store.state.post
          const isAuthor = post.user.id === store.state.me.id
          if (!isAuthor) {
            alert('게시물의 작성자만 게시물을 수정할 수 있습니다.')
            app.router.push('/post/' + params.postId)
            return false
          }
        })
        .catch(err => {
            app.router.push('/post/' + params.postId)
            return false
        })
        return true
    }
}
</script>
