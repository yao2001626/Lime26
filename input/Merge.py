#!/bin/python3

import os
import argparse
import json	
import re

print("*"*20 + "merge the assembly code for Lime" + "*"*20)
print("-"*60)
parser = argparse.ArgumentParser()
parser.add_argument("file_name", help="the filename of Lime code")
args = parser.parse_args()
lime_classes={}

def getMethodBody(name, lime_body_asm):
	start_str = '\s*_'+name+':'
	end_str = '\s*.cfi_endproc'
	flag = False
	res =""
	with open(lime_body_asm, "r") as read_body_file:
		for line in read_body_file:
			if 	re.match(start_str, line):
				flag = True
			elif flag and re.match(end_str, line):
				flag = False
			elif flag:
				res += line	
	# delete the first line: .start_function
	res = res.split("\n",1)[1]
	# delete the last line: ret
	res = res.replace('retl',';retl')
	res = res.replace('retq',';retq')
	res = res.replace('ret',';ret')
	res = res.replace('call	_malloc',';call	_malloc')
	res = res.replace('##',';')
	res = res.replace('.cfi',';')
	res = res.replace('ptr',' ')
	#print(res)
	return res

lime_classes.setdefault(args.file_name, [])
lime_struct_name = args.file_name +".json"
with open(lime_struct_name, "r") as read_struct_file:
	objs = json.load(read_struct_file)
	for obj in objs: 
		lime_body_asm = obj["class_name"] +".body.s"
		lime_skeleton_asm = obj["class_name"]+".skeleton.s"
		lime_asm = obj["class_name"]+".s"
		with open(lime_skeleton_asm, "r") as read_skeleton_file:
			skeleton = read_skeleton_file.read()
			with open(lime_body_asm, "r") as read_body_file:
				method_bodies = read_body_file.read()
				for method in obj["methods"]:
					m_name = "_"+obj["class_name"]+"_"+method+"_body"
					m_body = getMethodBody(obj["class_name"]+"_"+method, lime_body_asm)
					print(method)
					#print(obj["guards"])
					skeleton = skeleton.replace(m_name, m_body)
					m_guard_name = "_"+obj["class_name"]+"_"+method+"_guard"
					m_guard = obj["guards"].get(obj["class_name"]+method)
					skeleton = skeleton.replace(m_guard_name, m_guard)
					#print(m_guard_name)
					print(m_guard)
					#skeleton = skeleton.replace(m_guard_name, m_guard)
				for action in obj["actions"]:
					a_name = "_"+obj["class_name"]+"_"+action+"_body"
					a_body = getMethodBody(obj["class_name"]+"_"+action, lime_body_asm)
					print(action)
					#print(a_body)
					skeleton = skeleton.replace(a_name, a_body)
					a_guard_name = "_"+obj["class_name"]+"_"+action+"_guard"
					a_guard = obj["guards"].get(obj["class_name"]+action)
					skeleton = skeleton.replace(a_guard_name, a_guard)
					print(a_guard)

				init_code_name = "_"+obj["class_name"]+"_init_code"
				init_code = getMethodBody(obj["class_name"]+"_init_code", lime_body_asm)
				skeleton = skeleton.replace(init_code_name, init_code)

				with open(lime_asm, "w") as lime_asm:
					lime_asm.write(skeleton)



#if __name__ == "__main__":


