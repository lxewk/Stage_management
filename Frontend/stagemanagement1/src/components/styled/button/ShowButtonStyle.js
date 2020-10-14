import styled from 'styled-components';
import { colors } from '../global.js';
import { Link } from 'react-router-dom';
import  tim  from '../../../assets/jersey-boy-tim.svg'


export const ShowBtn = styled(Link)`
  color: ${colors.red};
  text-align: right;
  text-decoration: none;
  font-size: 2vw;
  font-weight: bold;
  padding: 35px 30px;
  height: 350px;
  width: 550px;
  cursor: pointer;
  background-color: ${colors.beam};
  background-image: url(${tim});
  background-repeat: no-repeat;
  background-position: 50% 25%;
  box-shadow: 0 4px 8px 0 rgba(0,0,0,0.2);

  &:hover {
    background-color: ${colors.gray};
  }

  @media screen and (max-width: 780px){
    justify-content: space-between;
  }

`;
