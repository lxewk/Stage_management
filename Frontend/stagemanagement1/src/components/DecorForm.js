import React, { useContext, useState } from 'react'
import { AuthContext } from '../contexts/AuthContex'
import { DecorContext } from '../contexts/DecorContext'
import axios from 'axios'

const NewDecorForm = () => {
    const { state: authState } = useContext(AuthContext)
    const { decors, decorDispatch } = useContext(DecorContext);
    const [name, setName] = useState('');
    const [department, setDepartment] = useState('');
    const [data, setData] = useState('')
    const [error, setError] = useState(false)

    const handleSubmit = (e) => {
        e.preventDefault();
        decorDispatch({type: 'ADD_DECOR', decor: {
            name, department
        }});

        const fetchData = async () => {
            try {
                data = await axios({
                    method: 'post',
                    url: 'http://localhost:8080/api/item/save',
                    data: JSON.stringify({
                        itemName: name,
                        department: department,
                    }),
                    headers: {
                        "Content-Type": "application/json",
                        Authorization: `Bearer ${authState.token}`
                    }
                })
                setData(data)
                console.log(data)
            } catch (error) {
                setError(error)
                console.log(error)
            }
        }
        fetchData()

        setName('')
        setDepartment('')
    }

    return (
        <form onSubmit={handleSubmit}>
            <input type="text" placeholder="decor name" value={name}
                onChange={(e) => setName(e.target.value)} required />
            <input type="text" placeholder="department" value={department}
                onChange={(e) => setDepartment(e.target.value)} required />
            <input type="submit" value="add decor" />
        </form>
    )
}

export default NewDecorForm;