import React, { useState, useEffect, useContext } from 'react';
import { DecorContext } from '../contexts/DecorContext';
import DecorForm from '../components/DecorForm';

const DecorList = () => {
    const { decors } = useContext(DecorContext);
    const [decorInfo, setDecorInfo] = useState([
        {name: 'DJ window', department: 'auto', id: 1 },
        {name: 'DJ table', department: 'props', id: 2 },
        {name: 'DJ headset', department: 'props', id: 3 },
    ]);

    const [decorCount, setDecorCount] = useState(3);

    useEffect(() => {
        console.log('useEffect hook ran', decors);
    })

    return ( 
        <div style={{padding: "150px"}}>
            <ul>
                {decorInfo.map(decor => {
                    return ( <li key={decor.id}>name: {decor.name},  department: {decor.department}</li>)
                })}
            </ul>
            <DecorForm {...decors}/>
            <button onClick={() => 
                setDecorCount(decorCount + 1)}>Add decor: {decorCount}
            </button>
        </div>
     );
}
 
export default DecorList;