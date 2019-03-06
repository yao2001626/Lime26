	.text
	.intel_syntax noprefix
	.file	"Node.c"
	.globl	Node_add                # -- Begin function Node_add
	.p2align	4, 0x90
	.type	Node_add,@function
Node_add:                               # @Node_add
	.cfi_startproc
# %bb.0:
	sub	esp, 12
	.cfi_def_cfa_offset 16
	mov	eax, dword ptr [esp + 20]
	mov	ecx, dword ptr [esp + 16]
	mov	dword ptr [esp + 8], eax
	mov	eax, dword ptr [esp + 8]
	cmp	dword ptr [eax + 24], 0
	mov	dword ptr [esp + 4], ecx # 4-byte Spill
	je	.LBB0_2
# %bb.1:
	mov	eax, dword ptr [esp + 8]
	mov	dword ptr [eax + 32], 1
	mov	eax, dword ptr [esp + 16]
	mov	ecx, dword ptr [esp + 8]
	mov	dword ptr [ecx + 20], eax
	jmp	.LBB0_8
.LBB0_2:
	mov	eax, dword ptr [esp + 16]
	mov	ecx, dword ptr [esp + 8]
	cmp	eax, dword ptr [ecx + 16]
	jge	.LBB0_4
# %bb.3:
	mov	eax, dword ptr [esp + 16]
	mov	ecx, esp
	mov	dword ptr [ecx], eax
	call	Node_init
	mov	ecx, dword ptr [esp + 8]
	mov	dword ptr [ecx + 24], eax
	mov	eax, dword ptr [esp + 8]
	mov	eax, dword ptr [eax + 16]
	mov	ecx, esp
	mov	dword ptr [ecx], eax
	call	Node_init
	mov	ecx, dword ptr [esp + 8]
	mov	dword ptr [ecx + 28], eax
	mov	eax, dword ptr [esp + 16]
	mov	ecx, dword ptr [esp + 8]
	mov	dword ptr [ecx + 16], eax
	jmp	.LBB0_7
.LBB0_4:
	mov	eax, dword ptr [esp + 16]
	mov	ecx, dword ptr [esp + 8]
	cmp	eax, dword ptr [ecx + 16]
	jle	.LBB0_6
# %bb.5:
	mov	eax, dword ptr [esp + 8]
	mov	eax, dword ptr [eax + 16]
	mov	ecx, esp
	mov	dword ptr [ecx], eax
	call	Node_init
	mov	ecx, dword ptr [esp + 8]
	mov	dword ptr [ecx + 24], eax
	mov	eax, dword ptr [esp + 16]
	mov	ecx, esp
	mov	dword ptr [ecx], eax
	call	Node_init
	mov	ecx, dword ptr [esp + 8]
	mov	dword ptr [ecx + 28], eax
.LBB0_6:
	jmp	.LBB0_7
.LBB0_7:
	jmp	.LBB0_8
.LBB0_8:
	add	esp, 12
	ret
.Lfunc_end0:
	.size	Node_add, .Lfunc_end0-Node_add
	.cfi_endproc
                                        # -- End function
	.globl	Node_has                # -- Begin function Node_has
	.p2align	4, 0x90
	.type	Node_has,@function
Node_has:                               # @Node_has
	.cfi_startproc
# %bb.0:
	sub	esp, 28
	.cfi_def_cfa_offset 32
	mov	eax, dword ptr [esp + 36]
	mov	ecx, dword ptr [esp + 32]
	mov	dword ptr [esp + 16], eax
	mov	eax, dword ptr [esp + 16]
	cmp	dword ptr [eax + 24], 0
	mov	dword ptr [esp + 12], ecx # 4-byte Spill
	jne	.LBB1_2
# %bb.1:
	mov	eax, dword ptr [esp + 32]
	mov	ecx, dword ptr [esp + 16]
	cmp	eax, dword ptr [ecx + 16]
	sete	dl
	and	dl, 1
	movzx	eax, dl
	mov	dword ptr [esp + 24], eax
	jmp	.LBB1_5
.LBB1_2:
	mov	eax, dword ptr [esp + 32]
	mov	ecx, dword ptr [esp + 16]
	cmp	eax, dword ptr [ecx + 16]
	jg	.LBB1_4
# %bb.3:
	mov	eax, dword ptr [esp + 32]
	mov	ecx, dword ptr [esp + 16]
	mov	ecx, dword ptr [ecx + 24]
	mov	dword ptr [esp], eax
	mov	dword ptr [esp + 4], ecx
	call	Node_has
	mov	dword ptr [esp + 24], eax
	jmp	.LBB1_5
.LBB1_4:
	mov	eax, dword ptr [esp + 32]
	mov	ecx, dword ptr [esp + 16]
	mov	ecx, dword ptr [ecx + 28]
	mov	dword ptr [esp], eax
	mov	dword ptr [esp + 4], ecx
	call	Node_has
	mov	dword ptr [esp + 24], eax
.LBB1_5:
	mov	eax, dword ptr [esp + 24]
	add	esp, 28
	ret
.Lfunc_end1:
	.size	Node_has, .Lfunc_end1-Node_has
	.cfi_endproc
                                        # -- End function
	.globl	Node_addToChild         # -- Begin function Node_addToChild
	.p2align	4, 0x90
	.type	Node_addToChild,@function
Node_addToChild:                        # @Node_addToChild
	.cfi_startproc
# %bb.0:
	sub	esp, 12
	.cfi_def_cfa_offset 16
	mov	eax, dword ptr [esp + 16]
	mov	ecx, dword ptr [esp + 16]
	mov	ecx, dword ptr [ecx + 20]
	mov	edx, dword ptr [esp + 16]
	cmp	ecx, dword ptr [edx + 16]
	mov	dword ptr [esp + 8], eax # 4-byte Spill
	jg	.LBB2_2
# %bb.1:
	mov	eax, dword ptr [esp + 16]
	mov	eax, dword ptr [eax + 20]
	mov	ecx, dword ptr [esp + 16]
	mov	ecx, dword ptr [ecx + 24]
	mov	dword ptr [esp], eax
	mov	dword ptr [esp + 4], ecx
	call	Node_add
	jmp	.LBB2_3
.LBB2_2:
	mov	eax, dword ptr [esp + 16]
	mov	eax, dword ptr [eax + 20]
	mov	ecx, dword ptr [esp + 16]
	mov	ecx, dword ptr [ecx + 28]
	mov	dword ptr [esp], eax
	mov	dword ptr [esp + 4], ecx
	call	Node_add
.LBB2_3:
	mov	eax, dword ptr [esp + 16]
	mov	dword ptr [eax + 32], 0
	add	esp, 12
	ret
.Lfunc_end2:
	.size	Node_addToChild, .Lfunc_end2-Node_addToChild
	.cfi_endproc
                                        # -- End function

	.ident	"clang version 6.0.0-1ubuntu2 (tags/RELEASE_600/final)"
	.section	".note.GNU-stack","",@progbits
