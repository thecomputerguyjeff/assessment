import React from 'react';
import {
    Navbar,
    NavbarBrand,

} from 'reactstrap';

const Header = (props) => {


    return (
        <div>
            <Navbar color="dark" light expand="md">
                <NavbarBrand>This is the homepage</NavbarBrand>

            </Navbar>
        </div>
    );
}

export default Header;