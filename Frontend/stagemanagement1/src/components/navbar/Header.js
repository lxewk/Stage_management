import React, { useState } from 'react'
import { MenuItems } from './MenuItems'

import { HeaderContainer,
         HeaderLogo,
         LogoSpan,
         LogoItalic 
} from '../styled/container/HeaderContainer'

import { NavMenu,
         ListItem,	
         MenuIcon,
         NavLinks,
         Icons,
         Bars,
} from './HeaderCss'

export const Header = () => {
  const [clicked, setClicked] = useState(false);
  const [hoverIndex, setHoverIndex] = useState(-1);
	
  const handleClick = () => {
    setClicked(!clicked);
  }

  return (
    <HeaderContainer>
      <HeaderLogo >
        <LogoItalic>STAGE</LogoItalic> <LogoSpan><i>M</i>anagement</LogoSpan> 
      </HeaderLogo>
      
      <NavMenu className={ clicked ? 'active' : '' }>   
        {MenuItems.map((item, index) => 
          <ListItem
            onMouseEnter={ () => setHoverIndex(index) }
            onMouseLeave={ () => setHoverIndex(-1) }
            style={{ background: hoverIndex === index ? '#6d76f7' : '' }}
          >
            <NavLinks
              to={item.path}
            >
              { item.title }
              <Icons className={item.icon} />
            </NavLinks>
          </ListItem>
        )}
        <MenuIcon onClick={handleClick}>
          <Bars className='fas fa-bars'/>
        </MenuIcon>
      </NavMenu>
    </HeaderContainer>
  );
};

export default Header;