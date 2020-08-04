import { combineReducers } from "redux";
import initialState from "../initialState";

const reducer: (state: AppState, action: Action) => AppState = (state : AppState = initialState, action: Action) => {
    const { type, payload } = action;
    switch (type) {
        case 'sidebar-action':
            return { ...state, isSideBarVisible: payload }
        default:
            return state
    }
};

export default combineReducers(reducer);