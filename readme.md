# vuex(상태 관리 라이브러리)
- 복잡한 어플리케이션 컴포넌트들을 효율적으로 관리하는 라이브러리
- vuex 등장 배경인 flux 패턴 소개
- Vuex 라이브러리 주요 속성: state, getters, mutations, actions
  * state: 여러 컴포넌트에서 공유되는 데이터 data
  * getter: 연산된 state 값을 접근하는 속성computed
  * mutations: state 값을 변경하는 이벤트 로직 methods
  * actions: 비동기 처리 로직을 선언하는 메소드 aysnc methods
- Vuex를 더 쉽게 코딩할 수 있는 방법으로 Helper 기능이 있음
 
## Vuex란?
- 무수히 많은 컴포넌트의 데이터를 관리하기 위한 상태 관리 패턴이자 라이브러리
- React의 Flux 패턴에서 기인

## Flux란?
- MVC 패턴의 복잡한 데이터 흐름 문제를 해결하는 개발 패턴(Unidirectional data flow)
- Flux 패턴: Action -> Dispatcher -> Mod
el -> VIew

## MVC 패턴의 문제점
- MVC 패턴: Controller -> Model <-> View
- 기능 및 추가 변경에 따라 생기는 문제점을 예측할 수 없음
- 앱이 복잡해지며 생기는 업데이트 루프

## Flux 패턴의 단방향 데이터 흐름
- 데이터 흐름이 여러 갈래로 나뉘지 않고 단방향으로만 처리
- Action -> Dispatcher -> Store -> View -> Action -> ..

## Vuex가 필요한 이유
1. MVC 패턴에서 발생하는 구조적 오류 해결
2. 컴토넌트 간 명시적 데이터 전달
3. 여러 개의 컴포넌트에서 같은 데이터를 업데이트 할 때 동기화 문제

## Vuex 컨셉
- State: 컴포넌트 간에 공유하는 데이터. data()
- View: 데이터를 표시하는 화면. template
- Action: 사용자의 입력에 따라 데이터를 변경하는 methods.

## Vuex 적용
- src/store 폴더 생성
- Vue.use(Vuex)

# Reference

