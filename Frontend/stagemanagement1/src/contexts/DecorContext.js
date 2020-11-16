import React, { createContext, useReducer } from 'react'
import { decorReducer } from '../reducers/decorReducer'


export const DecorContext = createContext();

const DecorContextProvider = (props) => {
    const [decors, decorDispatch] = useReducer(decorReducer, []);

    return (
        <DecorContext.Provider value={{decors, decorDispatch}}>
            { props.children }
        </DecorContext.Provider>
    )
}

export default DecorContextProvider;


