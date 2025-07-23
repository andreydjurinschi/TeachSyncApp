import './App.css';

import {
  BrowserRouter,
  Route,
  Routes,
} from 'react-router-dom';

import Home from './components/Home/Home';
import Header from './components/page-structure/Header';
import UserPage from './components/Users/UserPage';
import { projectInfo } from './data';

function App() {

  return (
    <div>
      <BrowserRouter>
      <Header /> 
      <Routes>
      <Route path="/" element={<Home {...projectInfo.project}
      />} />
        
      <Route path="/users" element={<UserPage />} />
      </Routes>
        
      </BrowserRouter>
    </div>
  );
}

export default App;
