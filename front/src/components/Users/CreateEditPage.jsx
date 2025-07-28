import {
  useEffect,
  useState,
} from 'react';

import {
  useNavigate,
  useParams,
} from 'react-router-dom';

export default function CreateEditPage(){
    const navigate = useNavigate();
    const { id } = useParams();
    const isEditMode = Boolean(id);

    const [user, setUser] = useState({
        username: "",
        password: "", 
        full_name: "",
        email: "",
        role: 0,
    });
    const [error, setError] = useState(null);
    const [loading, setLoading] = useState(false);

    useEffect(() => {
        if(isEditMode){
            setLoading(true)
            fetch(`http://localhost:8080/users/${id}`)
            .then((response) => {
                if(!response.ok){
                    throw new Error("Проблемы с сервером, попробуйте позэе");
                }
                return response.json();
            })
            .then((data)=> {
                setUser(data)
                setLoading(false)
            })
            .catch((error) => {
                setError(error.message)
                setLoading(false)
            })
        }else{
            setLoading(false)
        }
    }, [id, isEditMode])

    const handleChange = (e) => {
        const {name, value} = e.target
        setUser((prev) => ({... prev, [name]: value}))
    }

    
    const handleSubmit = (e) => {
        e.preventDefault()
        setLoading(true)
        setError(null)
        
    const url = isEditMode
      ? `http://localhost:8080/users/${id}`
      : `http://localhost:8080/users`;

        const method = isEditMode ? 'PUT' : 'POST'
        
        fetch(url, {
            method,
            headers: {
                'Content-Type': 'application/json',
            },
            body: JSON.stringify(user)
        }).then(async (response) => {
            if(!response.ok){
                const errorText = await response.text();
                throw new Error(errorText || 'Ошибка')
            }
            return response.json();
        })
        .then(() => {
            navigate('/users')
        })
        .catch((err) => {
            setError(err.message)
            setLoading(false)
        })
    }
    if (loading) return <p>Загрузка</p>
    if (error) return <p>{error}</p>

    return (
    <form onSubmit={handleSubmit}>
      <input
        name="full_name"
        value={user.full_name}
        onChange={handleChange}
        placeholder="Имя"
      />
    <input
    name="password"
    type="password"
    value={user.password}
    onChange={handleChange}
    placeholder="Пароль"
    required={!isEditMode}
    />
      <input
        name="username"
        value={user.username}
        onChange={handleChange}
        placeholder="Логин"
      />
      <input
        name="email"
        type="email"
        value={user.email}
        onChange={handleChange}
        placeholder="Email"
      />
      <select name="role" value={user.role} onChange={handleChange}>
        <option value="ADMIN">Admin</option>
        <option value="MANAGER">Manager</option>
        <option value="TEACHER">Teacher</option>
      </select>
      <button type="submit">
        {isEditMode ? 'Обновить' : 'Создать'}
      </button>
    </form>
  );
    
} 