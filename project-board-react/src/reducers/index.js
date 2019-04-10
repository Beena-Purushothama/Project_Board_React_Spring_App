import {combineReducers} from "redux";
import errorsReducers from "./errorsReducers";
import projectTaskReducer from "./projectTaskReducer";

export default combineReducers({
    errors:errorsReducers,
    project_tasks: projectTaskReducer
})