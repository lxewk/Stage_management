import React, { useContext }  from 'react'
import styled from 'styled-components'
import { colors } from '../components/styled/global'
import { DecorContext } from '../contexts/DecorContext'

const DecorList = () => {
    const { decors } = useContext(DecorContext)

    return ( 
        <DecorPage>
          <DecorListUl>
                {decors.map(decor => {
                    return ( 
                        <DecorListIl key={decor.name}>
                          <p>{decor.name} <b>Description:</b> {decor.description}</p>
                        </DecorListIl>
                    )
                })}
            </DecorListUl>
        </DecorPage>
     );
}
 
export default DecorList;

// styled components

const DecorPage = styled.div`
	display: block;
	padding: 100px 10px;
	margin-block-start: 0px;
  margin-block-end: 0px;
  margin-inline-start: 0px;
  margin-inline-end: 0px;
`;

const DecorListUl = styled.ul`
    padding: 0;
    list-style-type: none;

    @media screen and (max-width: 667px) {
      width: 80%;
    }
`;

const DecorListIl = styled.li`
    background: ${colors.logincardblue};
    border-radius: 5px;
    padding: 10px;
    cursor: pointer;
    margin: 10px 0;
    color: ${colors.black};
`;