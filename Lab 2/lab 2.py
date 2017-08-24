#Kin Chan
#Lab partner: Changmeng Xu

import types
from functools import reduce


class Zillion:
    def __init__(self, digits):
        
        self.digits = []
        
        if digits == '':
            raise RuntimeError
        
        for i in digits:
            
            if i >= "0" and i <= "9":
                count = 1
                self.digits += [int(i)]
                
            elif i == " " or i == ",":
                pass
            
            else:
                raise RuntimeError

        if self.digits == []:
            raise RuntimeError
            

    def increment(self):
        
        rightCounter = -1
        
        while (self.digits[rightCounter] == 9):
            
            self.digits[rightCounter] = 0
            rightCounter -= 1
            
            while ((-len(self.digits)) == rightCounter) and (self.digits[rightCounter] ==9):
                self.digits = [1] + self.digits

        if self.digits[rightCounter] != 9 and (rightCounter != (-len(self.digits))):
            self.digits[rightCounter] += 1
        if self.digits[rightCounter] == 0 and (rightCounter == (-len(self.digits))):
            self.digits[rightCounter] += 1
            
 
    def isZero(self):
        return reduce((lambda x,y: x+y), self.digits) == 0
            

    def toString(self):
        IntToStr = ''
        for i in range(len(self.digits)):
            IntToStr += str(self.digits[i])
        return IntToStr
            
            
#
#  TESTS. Test the class Zillion for CSci 1913 Lab 2.
#
#    James Moen
#    30 Jan 17
#
#  Every test is followed by a comment which shows what must be printed if your
#  code works correctly. It also shows how many points the test is worth, for a
#  total of nn possible points.
#

try:
  z = Zillion('')
except RuntimeError:
  print('Empty string')

# It must print 'Empty string' without apostrophes. 2 points.

try:
  z = Zillion(' , ')
except RuntimeError:
  print('No digits in the string')

# It must print 'No digits in the string' without apostrophes. 2 points.

try:
  z = Zillion('1+0')
except RuntimeError:
  print('Non-digit in the string')

# It must print 'Non-digit in the string' without apostrophes. 2 points.

try:
  z = Zillion('0')
except RuntimeError:
  print('This must not be printed')

#  It must print nothing. 2 points.

print(z.isZero())    #  It must print True. 2 points.

try:
  z = Zillion('000000000')
except RuntimeError:
  print('This must not be printed')

#  It must print nothing. 2 points.

print(z.isZero())    #  It must print True. 2 points.

try:
  z = Zillion('000 000 000')
except RuntimeError:
  print('This must not be printed')

#  It must print nothing. 2 points.

print(z.isZero())    #  It must print True. 2 points.

try:
  z = Zillion('997')
except RuntimeError:
  print('This must not be printed')

#  It must print nothing.  2 points.

print(z.isZero())    #  It must print False. 2 points.

print(z.toString())  #  It must print 997. 2 points.

z.increment()

print(z.toString())  #  It must print 998. 2 points.

z.increment()

print(z.toString())  #  It must print 999. 2 points.

z.increment()

print(z.toString())  #  It must print 1000. 2 points.

try:
  z = Zillion('0 9,9 9')
except:
  print('This must not be printed')

#  It must print nothing.  3 points.

z.increment()
print(z.toString())  #  It must print 1000. 2 points.

