export default function ({ store, redirect }) {
    const { isAuthorized } = store.getters

    if (!isAuthorized) {
        alert('로그인이 필요합니다!')
        return redirect('/signin')
    }
  }