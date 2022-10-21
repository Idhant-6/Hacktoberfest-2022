#!/usr/bin/env python
# coding: utf-8

# In[ ]:


class Node:
  def __init__(self,data):
    self.data=data
    self.next=None
    print('Node Created=>',data)
class circularList:
  def __init__(self):
    self.head=None
    self.ctr=0
  def insert_beg(self,data):
    node=Node(data)
    if self.head==None:
      self.head=node
      node.next=self.head
    #elif self.ctr==1:
      #node.next=self.head
      #self.head.next=node
      #self.head=node
    else:
      temp=self.head
      while temp.next is not self.head:
        temp=temp.next
      temp.next=node
      node.next=self.head
      self.head=node
    print('Node Inserted::> ',data)
    self.ctr+=1
    return
  def insert_end(self,data):
    node=Node(data)
    if self.head==None:
      self.head=node
      node.next=self.next
    else:
      temp=self.head
      while temp.next is not self.head:
        temp=temp.next
      temp.next=node
      node.next=self.head
    self.ctr+=1 
  def del_first(self):
    if self.head==None:
      print('No Nodes Exist')
    elif self. ctr==1:
      print('node deleted',self.head.data)
      self.head=None
      self.ct
    else:
      print("Node Deleted",self.head.data)
      self.head
      while temp.next is not self.head:
        temp=temp.next
      self.head=self.head.next
      temp.next=self.head
    self.ctr-=1 
  def traverse(self):
    temp=self.head
    i=0
    while i<self.ctr:
      print('Node=>',temp.data)
      temp=temp.next
      i+=1
    return
def menu():
  print('1.insert_beg')
  print('2.insert_last')
  print('3.print')
  print('4.exit')
  print('5.delete front')
  ch= eval(input("Enter a  number:"))
  return ch

obj=circularList()
print("++++++++++++circular list+++++++")
while True:
    ch=menu()
    if ch==1:
  
      data=input("enter data")
      
      obj.insert_beg(data)
    elif ch==2:
      data=input("enter data")
      obj.insert_end(data)
    elif ch==3:
      print("printing")
      obj.traverse()
    elif ch==5:
      print("deleting front")
      obj.del_first()
    else:
      print("Exit")
      break
