 export default function ({ app }) {
    app.router.beforeResolve((to, from, next) => {
        store.dispatch('fetchPost', to.params.postId)
        .then(res => {
          const post = store.state.post
          const isAuthor = post.user.id === store.state.me.id
          if (!isAuthor) {
            alert('게시물의 작성자만 게시물을 수정할 수 있습니다.')
            next(from)
          }
        })
        .catch(err => {
          alert(err.response.data.msg)
          next(from)
        })
    });
}