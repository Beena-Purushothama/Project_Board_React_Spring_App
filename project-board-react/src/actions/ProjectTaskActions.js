import axios from "axios";
import {GET_PROJECT_TASKS, GET_ERRORS,DELETE_PROJECT_TASK,GET_PROJECT_TASK} from "./Types"

export const addProjectTask = (project_task, history) => async dispatch => {
    try{
        await axios.post("http://localhost:8080/api/dashboard", project_task);
        history.push("/");    
    }catch(error){
        dispatch({
            type : GET_ERRORS,
            payload : error.response.data
        });
    }
};
   
export const getBacklog = () => async dispatch =>{
    const res = await axios.get("http://localhost:8080/api/dashboard/all")
    dispatch({
        type: GET_PROJECT_TASKS,
        payload:res.data
    });
};

export const deleteProjectTask = pt_id => async dispatch => {
    if(window.confirm(`Delete project Task? ${pt_id}`)){
        await axios.delete(`http://localhost:8080/api/dashboard/${pt_id}`)
    dispatch({
        type : DELETE_PROJECT_TASK,
        payload: pt_id
    })
    };
    
};

export const getProjectTask = (pt_id,history) => async dispatch => {
    try {
        const res = await axios.get(`http://localhost:8080/api/dashboard/${pt_id}`)
        dispatch({
            type : GET_PROJECT_TASK,
            payload: res.data
        })
        }
     catch (error) {
        history.push("/");
    }
}