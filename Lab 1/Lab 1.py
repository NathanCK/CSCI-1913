#Kin Chan
#Lab partner: Changmeng Xu 

import types

def left(e):
 return e[0]

def op(e):
 return e[1]

def right(e):
 return e[2]

def isInside(v, e):
    if type(e) == tuple:
        if type(left(e)) == tuple:
            return isInside(v, left(e))
        elif type(right(e)) == tuple:
            return isInside(v, right(e))
        else:
            return (v == left(e)) or (v == right(e))
    else:
        return v == e


def solve(v, q):
    if isInside(v, left(q)):
        return solving(v, q)
    elif isInside(v, right(q)):
        return solving(v, (right(q), op(q), left(q)))
    else:
        return None
                       
def solving(v, q):
    if isInside(v, left(q)):
        if v == left(q):
            return q
        elif op(left(q)) == '+':
            return solvingAdd(v, q)
        elif op(left(q)) == '-':
            return solvingSubtract(v, q)
        elif op(left(q)) == '*':
            return solvingMultiply(v, q)
        elif op(left(q)) == '/':
            return solvingDivide(v, q)

def solvingAdd(v, q):
    if isInside(v, left(left(q))):
        return solving(v, (left(left(q)), op(q), (right(q), '-', right(left(q)))))
    else:
        return solving(v, (right(left(q)), op(q), (right(q), '-', left(left(q)))))
    
    

def solvingSubtract(v, q):
    if isInside(v, left(left(q))):
        return solving(v, (left(left(q)), op(q), (right(q), '+', right(left(q)))))
    else:
        return solving(v, (right(left(q)), op(q), (left(left(q)), '-', right(q))))
    
 

def solvingMultiply(v, q):
    if isInside(v, left(left(q))):
        return solving(v, (left(left(q)), op(q), (right(q), '/', right(left(q)))))
    else:
        return solving(v, (right(left(q)), op(q), (right(q), '/', left(left(q)))))
    
                         

def solvingDivide(v, q):
    if isInside(v, left(left(q))):
        return solving(v, (left(left(q)), op(q), (right(q), '*', right(left(q)))))
    else:
        return solving(v, (right(left(q)), op(q), (left(left(q)), '/', right(q))))
    
    
                
        
    
    
                       
                       
        

    

    
