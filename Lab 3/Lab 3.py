#Kin Chan
#Lab partner: Changmeng Xu


from functools import reduce

def most(P, S):
    if S == []:
        return False
    elif len(list(filter(lambda x: P(x), S))) > len(list(filter(lambda x:not P(x), S))):
        return True
    elif len(list(filter(lambda x: P(x), S))) == len(list(filter(lambda x:not P(x), S))):
        return False
    elif len(list(filter(lambda x: P(x), S))) < len(list(filter(lambda x:not P(x), S))):
        return False
    

def sigma(F, B, E):
    if B > E:
        return 0
    else:
        return reduce((lambda x,y: x + F(y)), range(B, E+1), 0)

#  Tests for Computer Laboratory 3. The comments show what each call must print
#  and how many points each test is worth -- for a total of 20 points.

#  ODD. Assume N is an integer. Test if N is odd.

def odd(N):
  return N % 2 != 0

print(most(odd, []))         #  False    2 points
print(most(odd, [0]))        #  False    2 points
print(most(odd, [1]))        #  True     2 points
print(most(odd, [1, 2]))     #  False    2 points
print(most(odd, [1, 2, 3]))  #  True     2 points


#  SQR. Assume N is a number. Return N times N.

def sqr(N):
  return N * N

print(sigma(sqr, 0, 0))    #  0          2 points
print(sigma(sqr, 1, 0))    #  0          2 points
print(sigma(sqr, 0, 4))    #  30         2 points
print(sigma(sqr, 1, 1))    #  1          2 points
print(sigma(sqr, 2, 100))  #  338349     2 points
