fn main() {
    println!("This program differentiates polynomials in x.");
    let p = Polynomial::new(String::from("4x-2x^3"));
    println!("{:?}", p);
    let p_diff = p.differentiate();
    println!("{}", p_diff.to_string());
}

#[derive(Debug)]
struct Monomial{
    coeff: i32,
    degree: i32,
}

#[derive(Debug)]
struct Polynomial{
    poly: Vec<Monomial>,
}

impl Monomial{
    fn new(mut mono: String) -> Monomial{
        let var_index = match mono.find('x'){
            Some(val) => val,
            None => mono.len() //panic!("monomial not in x"). really bad; assumes if x isnt there its a constant. if something else is thrown in there one of the parse ints later on throws an error so i guess it kinda sorta works intentionally
        };
        let mut degree_str = mono.split_off(var_index);
        if mono.contains("+"){
            mono.remove(0);//if has +, will be at beginning of str, otherwise will have '-' which we want to parse as part of the number
        }

        let mut deg0 = false;//bruh there has to be a better way to do this
        let mut deg1 = false;
        if degree_str.contains('x'){
            degree_str.remove(0);
            if degree_str.contains('^'){
                degree_str.remove(0);
            } else{
                deg1 = true;
            } 
        } else{
            deg0 = true;
        }

        return Monomial{
            degree: match degree_str.parse::<i32>(){
                Ok(num) => num,
                Err(e) => 
                if deg1{
                    1
                } else if deg0{
                    0
                } else {
                panic!("couldn't parse monomial degree: {:?}", e);
                }
            },
            coeff: match mono.parse::<i32>(){
                Ok(num) => num,
                Err(e) => 
                if mono.is_empty(){//if cant parse is prolly cause there is nothing there which corresponds to a non-written coefficient of 1
                    1
                } else{
                panic!("couldn't parse monomial coefficient: {:?}", e);
                },
            }, 
        }
    }

    fn differentiate(self) -> Monomial{
        return Monomial{
            coeff: self.coeff*self.degree,
            degree: if self.degree != 0{
                self.degree - 1
            } else{
                0
            }
        };
    }

    fn to_string(&self) -> String {
        if self.degree == 0{
            return String::from(self.coeff.to_string());
        } else if self.degree == 1{
            return String::from(self.coeff.to_string() + "x");
        } else {
            return String::from(self.coeff.to_string() + "x^" + &self.degree.to_string());
        }
    }
}

impl Polynomial{
    fn new(poly: String) -> Polynomial {
        let formatted_poly = poly.replace("-", "+-");//puts plus sign in front of all negative numbers
        let monos = formatted_poly.split_terminator('+');//splits into vector based on location of pluses
        let mut mononos: Vec<Monomial> = Vec::new();//good var name
        for mono in monos{
            mononos.push(Monomial::new(String::from(mono)));
        }
        return Polynomial{
            poly:mononos
        }
    }

    fn differentiate(self) -> Polynomial{
        let mut diff_poly: Vec<Monomial> = Vec::new();
        for i in self.poly {
            diff_poly.push(i.differentiate());
        }
        return Polynomial{
            poly: diff_poly,
        }
    }

    fn to_string(&self) -> String{
        let mut poly_str: String = String::from("");
        for i in &self.poly{
            poly_str.push_str(&i.to_string());
            if !i.to_string().contains('-'){
                poly_str.push('+');//only add plus sign if no minus sign
            }
        }
        poly_str.remove(poly_str.len()-1);//remove last + sign that gets added at the end cause this is janky and idk how to not have that last + get added rn
        return poly_str;
    }
}


