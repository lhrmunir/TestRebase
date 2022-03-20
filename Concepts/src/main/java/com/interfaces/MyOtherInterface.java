package com.interfaces;
/*
        In interface, variable are by default assign by public,static,final access modifier. Because :
                      ======================================================================

        public : It happen some-times that interface might placed in some other package.
                 So it need to access the variable from anywhere in project.

        static : As such incomplete class can not create object. So in project we need to access the variable without object
                 so we can access with the help of interface_filename.variable_name

        final : Suppose one interface implements by many class and all classes try to access and update the interface variable.
                So it leads to inconsistent of changing data and affect every other class. So it need to declare access modifier with final.
 */
public interface MyOtherInterface {

    public void sayGoodbye();
}
