import { createStore, applyMiddleware } from "redux";
import reducer from "./Reducer";
import middleware from "./App/middleware";
import initialState from "./Reducer/initialState";

const store = createStore(reducer, initialState, applyMiddleware(middleware));

export default store;