import { combineReducers } from "redux";
import filterReducer from '../Filters/Reducer';


export default combineReducers({
    filters: filterReducer
});