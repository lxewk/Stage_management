import React, { createContext, useState, useReducer } from 'react'

const DecorContext = createContext();

const decorReducer = (state, action) => {
    switch(action.type){
        case 'ADD_NAME':
            return
    }
}

const DecorContextProvider = (props) => {

    const [decor, dispatch] = useReducer(decorReducer, [
        { name: 'DJ table', department: 'decor', id: 1 },
        { name: 'DJ window', department: 'auto', id: 2 },
        { name: 'DJ headset', department: 'prop', id: 3 }
    ]);

    return (
        <DecorContext.Provider value={decor}>
            {props.children}
        </DecorContext.Provider>
    )
}


