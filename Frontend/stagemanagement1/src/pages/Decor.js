import React, { useState, useEffect, useContext } from 'react'
import styled from 'styled-components'
import { colors } from '../components/styled/global'

import { DecorContext } from '../contexts/DecorContext'
import DecorForm from '../components/item/DecorForm'


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
        <DecorListContainer>
            <DecorListUl>
                {decors.map(decor => {
                    return ( <DecorListLi key={decor.name}>name: {decor.name} {decor.department}</DecorListLi>)
                })}
            </DecorListUl>
            <DecorForm {...decors}/><br /><br />
            <DecorListBtn onClick={() => 
                setDecorCount(decorCount + 1)}>Add decor: {decorCount}
            </DecorListBtn>
        </DecorListContainer>
     );
}
 
export default DecorList;

// styled components

// DecorHeader
const DecorHeader = styled.header`

`;

// DecorList
const DecorListContainer = styled.div`
    padding: 120px;
`;

const DecorListUl = styled.ul`
    padding: 0;
    list-style-type: none;
`;

const DecorListLi = styled.li`
    background: ${colors.headerBlue};
    border-radius: 5px;
    padding: 10px;
    cursor: pointer;
    margin: 10px 0;
    color: ${colors.headerLogoWhite};
    font-weight: bold;
`;

const DecorListBtn = styled.button`
  padding: 5px;
  height: 40px;
  border-radius: 5px;
  border: .5px solid rgb(143, 143, 143);
  font-size: 15px;
`;