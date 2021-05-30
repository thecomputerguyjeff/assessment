import React from 'react';
import {
    Navbar,
    NavbarBrand,

} from 'reactstrap';

const Header = (props) => {


    return (
        <div>
            <Navbar color="light" light expand="md">
                <NavbarBrand>Welcome to the homepage</NavbarBrand>

            </Navbar>
        </div>
    );
}

export default Header;