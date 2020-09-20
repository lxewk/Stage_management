import styled, { css } from "styled-components";
import { colors } from "../styles/global";

export const LoginBtn = styled.button`
  height: 40px;
  font-weight: bold;
  font-size: 15px;
  border-radius: 100px;
  background-color: ${colors.gray};
  color: ${colors.black};
  cursor: pointer;

  &:hover {
    background-color: ${colors.stage};
  }
  
  ${props => props.outline && css`
    outline: none !important;
    `}
`;