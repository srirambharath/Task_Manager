
import './App.css';
import { Route, BrowserRouter as Router, Routes } from 'react-router-dom';
import ListCourses from './Components/ListCourses';
import AddCourses from './Components/AddCourses';

function App() {
  return (
    <div>
      <Router>
        <Routes>
          <Route path="/" Component={ListCourses} />
          <Route path="/listcourses" Component={ListCourses} />
          <Route path="/add-course" Component={AddCourses} />
          <Route path="/add-course/:id" Component={AddCourses} />
        </Routes>
      </Router> 
    </div>
  );
}

export default App;
