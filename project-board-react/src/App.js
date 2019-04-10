import React, { Component } from 'react';
import {Route} from "react-router-dom";
import './App.css';
import "bootstrap/dist/css/bootstrap.min.css";
import Navbar from './components/Navbar.js';
import Projectboard from './components/Projectboard.js';
import AddProjectTask from './components/ProjectTasks/AddProjectTask';
import UpdateProjectTask from './components/ProjectTasks/UpdateProjectTask';

class App extends Component {
  render() {
    return (
      <div className="App">
        <Navbar/>
        <Route exact path="/" component={Projectboard} />
        <Route exact path="/addProjectTask" component={AddProjectTask} />
        <Route exact path="/updateProjectTask/:pt_id" component={UpdateProjectTask}/>
      </div>
    );
  }
}

export default App;
