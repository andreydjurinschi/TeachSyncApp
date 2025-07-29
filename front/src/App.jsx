import './App.css';

import {
  BrowserRouter,
  Route,
  Routes,
} from 'react-router-dom';

import Home from './components/Home/Home';
import Header from './components/page-structure/Header';
import UserPage from './components/Users/UserPage';
import UserDetailPage from './components/Users/UserDetailPage';
import { projectInfo } from './data';
import CreateEditPage from './components/Users/CreateEditPage';
import DeleteUserPage from './components/Users/DeleteUserPage';

function App() {

  return (
    <div>
      <BrowserRouter>
      <Header /> 
      <Routes>
      <Route path="/" element={<Home {...projectInfo.project}
      />} />
      <Route path="/users" element={<UserPage />} />
      <Route path="/users/:id" element={<UserDetailPage />} />
      <Route path="/users-create" element={<CreateEditPage />} />
      <Route path="/users/edit/:id" element={<CreateEditPage />} />
      <Route path="/users/delete/:id" element={<DeleteUserPage />} />
      </Routes>        
      </BrowserRouter>
    </div>
  );
}
export default App;