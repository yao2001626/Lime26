align 4
segment .data
segment .bss
segment .text

global switch_to
global switch_to_sched
;the object should be locked before executing this switch_to
switch_to:
	MOV  ECX, [ESP + 4] 	;coro_stack
	MOV  EAX, [ECX]
	MOV  EDX, [ECX + 4]
	MOV  [ECX], EBP
	MOV  [ECX + 4], ESP
	MOV  EBP, EAX
	MOV  ESP, EDX

	RET
; the objec is unlocked in the switch_to_sched
switch_to_sched:             ;don't need argument
	MOV EAX, [EBP]           ;pre EBP
	MOV ECX, [EBP + 4]       ;pre ESP
	MOV [EBP], EBP
	MOV [EBP + 4], ESP
	MOV dword [EBP + 8], 0	 ;unlock the current object
	MOV EBP, EAX
	MOV ESP, ECX
	RET