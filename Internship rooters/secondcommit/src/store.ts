import { createStore, applyMiddleware } from "redux";
import reducer from "./Reducer";
import middleware from "./middleware";
import initialState from "./initialState";

const store = createStore(reducer, initialState, applyMiddleware(middleware));

export default store;