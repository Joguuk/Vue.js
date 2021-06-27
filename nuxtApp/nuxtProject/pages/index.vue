<template>
    <div class="post-list-page">
        <h1>포스트 게시글</h1>
        <post-list :posts="posts"/>
        <!-- <nuxt-link :to="{ path: '/post/create' }">글쓰기</nuxt-link> -->
        <nuxt-link to="/post/create">글쓰기</nuxt-link>
    </div>
</template>

<script>
import PostList from '@/components/PostList'
import { mapState, mapActions } from 'vuex'

export default {
    name: 'PostListPage',
    components: { PostList },
    created() {
        this.fetchPostList();
    },
    methods: {
        ...mapActions(['fetchPostList'])
    },
    computed: {
        ...mapState(['posts'])
    },
}
</script>