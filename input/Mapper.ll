; ModuleID = 'Mapper.c'
source_filename = "Mapper.c"
target datalayout = "e-m:e-i64:64-f80:128-n8:16:32:64-S128"
target triple = "x86_64-pc-linux-gnu"

%struct.Mapper_struct = type { i32, i32, i32, i32, %struct.Reducer_struct*, i32, i32, i32 }
%struct.Reducer_struct = type opaque

; Function Attrs: noinline nounwind optnone uwtable
define void @Mapper_map(i32, %struct.Mapper_struct*) #0 {
  %3 = alloca i32, align 4
  %4 = alloca %struct.Mapper_struct*, align 8
  store i32 %0, i32* %3, align 4
  store %struct.Mapper_struct* %1, %struct.Mapper_struct** %4, align 8
  %5 = load i32, i32* %3, align 4
  %6 = load %struct.Mapper_struct*, %struct.Mapper_struct** %4, align 8
  %7 = getelementptr inbounds %struct.Mapper_struct, %struct.Mapper_struct* %6, i32 0, i32 6
  store i32 %5, i32* %7, align 4
  %8 = load %struct.Mapper_struct*, %struct.Mapper_struct** %4, align 8
  %9 = getelementptr inbounds %struct.Mapper_struct, %struct.Mapper_struct* %8, i32 0, i32 5
  store i32 1, i32* %9, align 8
  ret void
}

; Function Attrs: noinline nounwind optnone uwtable
define void @Mapper_doMap(%struct.Mapper_struct*) #0 {
  %2 = alloca %struct.Mapper_struct*, align 8
  store %struct.Mapper_struct* %0, %struct.Mapper_struct** %2, align 8
  %3 = load %struct.Mapper_struct*, %struct.Mapper_struct** %2, align 8
  %4 = getelementptr inbounds %struct.Mapper_struct, %struct.Mapper_struct* %3, i32 0, i32 7
  %5 = load i32, i32* %4, align 8
  %6 = srem i32 %5, 2
  %7 = icmp eq i32 %6, 0
  br i1 %7, label %8, label %20

; <label>:8:                                      ; preds = %1
  %9 = load %struct.Mapper_struct*, %struct.Mapper_struct** %2, align 8
  %10 = getelementptr inbounds %struct.Mapper_struct, %struct.Mapper_struct* %9, i32 0, i32 6
  %11 = load i32, i32* %10, align 4
  %12 = load %struct.Mapper_struct*, %struct.Mapper_struct** %2, align 8
  %13 = getelementptr inbounds %struct.Mapper_struct, %struct.Mapper_struct* %12, i32 0, i32 6
  %14 = load i32, i32* %13, align 4
  %15 = mul nsw i32 %11, %14
  %16 = load %struct.Mapper_struct*, %struct.Mapper_struct** %2, align 8
  %17 = getelementptr inbounds %struct.Mapper_struct, %struct.Mapper_struct* %16, i32 0, i32 4
  %18 = load %struct.Reducer_struct*, %struct.Reducer_struct** %17, align 8
  %19 = call i32 (i32, %struct.Reducer_struct*, ...) bitcast (i32 (...)* @Reducer_reduce1 to i32 (i32, %struct.Reducer_struct*, ...)*)(i32 %15, %struct.Reducer_struct* %18)
  br label %32

; <label>:20:                                     ; preds = %1
  %21 = load %struct.Mapper_struct*, %struct.Mapper_struct** %2, align 8
  %22 = getelementptr inbounds %struct.Mapper_struct, %struct.Mapper_struct* %21, i32 0, i32 6
  %23 = load i32, i32* %22, align 4
  %24 = load %struct.Mapper_struct*, %struct.Mapper_struct** %2, align 8
  %25 = getelementptr inbounds %struct.Mapper_struct, %struct.Mapper_struct* %24, i32 0, i32 6
  %26 = load i32, i32* %25, align 4
  %27 = mul nsw i32 %23, %26
  %28 = load %struct.Mapper_struct*, %struct.Mapper_struct** %2, align 8
  %29 = getelementptr inbounds %struct.Mapper_struct, %struct.Mapper_struct* %28, i32 0, i32 4
  %30 = load %struct.Reducer_struct*, %struct.Reducer_struct** %29, align 8
  %31 = call i32 (i32, %struct.Reducer_struct*, ...) bitcast (i32 (...)* @Reducer_reduce2 to i32 (i32, %struct.Reducer_struct*, ...)*)(i32 %27, %struct.Reducer_struct* %30)
  br label %32

; <label>:32:                                     ; preds = %20, %8
  %33 = load %struct.Mapper_struct*, %struct.Mapper_struct** %2, align 8
  %34 = getelementptr inbounds %struct.Mapper_struct, %struct.Mapper_struct* %33, i32 0, i32 5
  store i32 0, i32* %34, align 8
  ret void
}

declare i32 @Reducer_reduce1(...) #1

declare i32 @Reducer_reduce2(...) #1

attributes #0 = { noinline nounwind optnone uwtable "correctly-rounded-divide-sqrt-fp-math"="false" "disable-tail-calls"="false" "less-precise-fpmad"="false" "no-frame-pointer-elim"="false" "no-infs-fp-math"="false" "no-jump-tables"="false" "no-nans-fp-math"="false" "no-signed-zeros-fp-math"="false" "no-trapping-math"="false" "stack-protector-buffer-size"="8" "target-cpu"="x86-64" "target-features"="+fxsr,+mmx,+sse,+sse2,+x87" "unsafe-fp-math"="false" "use-soft-float"="false" }
attributes #1 = { "correctly-rounded-divide-sqrt-fp-math"="false" "disable-tail-calls"="false" "less-precise-fpmad"="false" "no-frame-pointer-elim"="false" "no-infs-fp-math"="false" "no-nans-fp-math"="false" "no-signed-zeros-fp-math"="false" "no-trapping-math"="false" "stack-protector-buffer-size"="8" "target-cpu"="x86-64" "target-features"="+fxsr,+mmx,+sse,+sse2,+x87" "unsafe-fp-math"="false" "use-soft-float"="false" }

!llvm.module.flags = !{!0}
!llvm.ident = !{!1}

!0 = !{i32 1, !"wchar_size", i32 4}
!1 = !{!"clang version 6.0.0-1ubuntu2 (tags/RELEASE_600/final)"}
