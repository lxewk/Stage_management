import React, { useState } from 'react';
import { MenuItems } from './MenuItems';

import { HeaderContainer,
         HeaderLogo,
         LogoSpan,
         LogoItalic 
} from '../styled/container/HeaderContainer';

import { NavMenu,	
         MenuIcon,
         NavLinks,
         Bars,
} from './HeaderCss';

export const Header = () => {
	const [clicked, setClicked] = useState(false);
	
  const handleClick = () => {
    setClicked(!clicked);
  }

  return (
    <HeaderContainer>
      <HeaderLogo >
        <LogoItalic>STAGE</LogoItalic> <LogoSpan><i>M</i>anagement</LogoSpan> 
      </HeaderLogo>
      <MenuIcon onClick={handleClick}>
        <Bars className={clicked ? 'fas fa-times' : 'fas fa-bars'}></Bars>
      </MenuIcon>
      <NavMenu className={{active: setClicked}}>
        {MenuItems.map((item, index) => {
          return (
            <li key={index}>
              <NavLinks href={item.path}>
              	{item.title}
              </NavLinks>
            </li>
          )
        })}
      </NavMenu>
    </HeaderContainer>
  );
};

export default Header;