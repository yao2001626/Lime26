
align 4
segment .data
segment .bss
segment .text
extern  switch_to_sched
extern  runqput
extern  malloc

; global methods declare
; global Mapper_methods
global Mapper_init 
global Mapper_map 
; global methods declare

Mapper_init:
Mapper_init_realloc:
    PUSH DWORD 32768
    CALL malloc
    ADD  ESP, 4
    CMP  DWORD EAX, 0
    JE   Mapper_init_realloc
    MOV  DWORD [EAX + 32768 - 1*4], 0    ; next 
    MOV  DWORD [EAX + 32768 - 2*4], 0    ; a 
    MOV  DWORD [EAX + 32768 - 3*4], 0    ; e 
    MOV  DWORD [EAX + 32768 - 4*4], 0    ; index 
    MOV  DWORD [EAX + 32768 - 32 + 12], 0    ; next
    MOV  DWORD [EAX + 32768 - 32 + 8], 0     ; lock
    LEA  ECX,  [EAX + 32768 - 32 - 4]
    MOV  DWORD [EAX + 32768 - 32 + 4], ECX   ; Pre ESP
    LEA  ECX,  [EAX + 32768 - 32]
    MOV  DWORD [EAX + 32768 - 32], ECX       ; Pre EBP
    LEA  ECX,  [Mapper_doactions]
    MOV  DWORD [EAX + 32768 - 32 - 4], ECX   ; Mapper_doactions
    ADD  DWORD EAX, 32768 - 32
    PUSH DWORD EBP
    PUSH DWORD EAX
    CALL runqput
    POP  DWORD EAX
    POP  DWORD EBP
    ; init code goes here
    ; 
    ; init code ends here
    RET

Mapper_doactions:
Mapper_doactions_start:
    PUSH DWORD EBP
    ; CALL Mapper_action
    CALL Mapper_doMap
    POP  EBP
    CALL switch_to_sched
    JMP  Mapper_doactions_start
    RET  ; never be here;define method _Mapper_map
_Mapper_map:
_Mapper_map_start:
    MOV  DWORD ECX, [ESP + 4 + 4*1]   ; + 4 * num(para)
_Mapper_map_checklock:
    MOV  DWORD EAX, 1           ;lock
    XCHG EAX, [ECX + 8]
    CMP  DWORD EAX, 0
    JNE  _Mapper_map_suspend
_Mapper_map_checkguard:
    ; method guard starts here
    MOV DWORD EAX, [ECX + 20]
    CMP DWORD EAX, 1
    JNE _Mapper_map_succeed

    ; method guard ends here
_Mapper_map_checkguard_fail:
    MOV  DWORD [ECX + 8], 0     ; unlock
_Mapper_map_suspend:
    PUSH DWORD EBP
    CALL runqput
    POP  EBP
    CALL switch_to_sched
    JMP  _Mapper_map_start
_Mapper_map_succeed:
    ; method body starts here
    _	.cfi_startproc
	movl	4(%esp), %eax
	movl	8(%esp), %ecx
	movl	%eax, 24(%ecx)
	movl	$1, 20(%ecx)

    ; method body ends here
_Mapper_map_unlock:
    MOV  DWORD ECX, [ESP + 4 + 4*1]   ; + 4 * num(para)
    PUSH DWORD EAX              ; for the return val
    PUSH DWORD EBP
    PUSH DWORD ECX
    CALL runqput
    POP  DWORD ECX
    POP  DWORD EBP
    POP  DWORD EAX              ; for the return val
    ; unlock
    MOV DWORD [ECX + 8], 0
_Mapper_map_ret:
    RET ; define action
; _Mapper: doMap 
_Mapper_doMap:
_Mapper_doMap_start:
    MOV  DWORD ECX, [ESP + 4]
    ; action guard start
    MOV DWORD EAX, [ECX + 20]
    CMP DWORD EAX, 1
    JE _Mapper_doMap_succeed

    ; action guard end

    JMP   _Mapper_doMap_checkguard_fail
_Mapper_doMap_succeed:
    ; action body start
    _	.cfi_startproc
	movl	4(%esp), %eax
	movl	16(%eax), %ecx
	movl	24(%eax), %edx
	imull	%edx, %edx
	testb	$1, 28(%eax)
	jne	LBB4_2
	movl	%edx, 32(%ecx)
	movl	$1, 24(%ecx)
	jmp	LBB4_3
LBB4_2:
	movl	%edx, 36(%ecx)
	movl	$1, 28(%ecx)
LBB4_3:
	movl	$1, 20(%eax)

    ; action body end
_Mapper_doMap__checkguard_fail:
    RET