import React, { useState, useEffect, useContext } from 'react'
import { DecorContext } from '../contexts/DecorContext'
import DecorForm from '../components/DecorForm'


const DecorList = () => {
    const { decors } = useContext(DecorContext)
    
    const [decorCount, setDecorCount] = useState(0)

    useEffect(() => {
        console.log('useEffect hook Decors ran', decors)
    }, [decors])

    

    useEffect(() => {
        console.log('useEffect hook decorCount ran', decorCount);
    }, [decorCount])

    return ( 
        <div style={{padding: "150px"}}>
            <ul>
                {decors.map(decor => {
                    return ( <li key={decor.name}>name: {decor.name},  department: {decor.department}</li>)
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