import React, { useContext, useState } from 'react';
import { DecorContext } from '../contexts/DecorContext';

const NewDecorForm = () => {
    const { dispatch } = useContext(DecorContext);
    const [name, setName] = useState('');
    const [department, setDepartment] = useState('');
    const handleSubmit = (e) => {
        e.preventDefault();
        dispatch({type: 'ADD_DECOR', decor: {
            name, department
        }});
        setName('');
        setDepartment('');
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
